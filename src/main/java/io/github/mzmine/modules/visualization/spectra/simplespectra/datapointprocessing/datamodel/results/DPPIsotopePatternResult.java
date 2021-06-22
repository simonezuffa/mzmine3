/*
 * Copyright 2006-2020 The MZmine Development Team
 * 
 * This file is part of MZmine.
 * 
 * MZmine is free software; you can redistribute it and/or modify it under the terms of the GNU
 * General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * 
 * MZmine is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with MZmine; if not,
 * write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301
 * USA
 */

package io.github.mzmine.modules.visualization.spectra.simplespectra.datapointprocessing.datamodel.results;

import org.jetbrains.annotations.Nullable;

import io.github.mzmine.datamodel.IsotopePattern;
import io.github.mzmine.modules.visualization.spectra.simplespectra.datapointprocessing.datamodel.ProcessedDataPoint;

/**
 * Used to store a detected isotope pattern in a
 * {@link io.github.mzmine.modules.datapointprocessing.datamodel.ProcessedDataPoint}.
 * 
 * @author SteffenHeu steffen.heuckeroth@gmx.de / s_heuc03@uni-muenster.de
 *
 */
public class DPPIsotopePatternResult extends DPPResult<IsotopePattern> {

  private ProcessedDataPoint[] linkedDataPoints;
  private final int charge;

  public DPPIsotopePatternResult(IsotopePattern value, ProcessedDataPoint[] linkedDataPoints,
      int charge) {
    super(value);

    if (value.getNumberOfDataPoints() == linkedDataPoints.length) {
      this.linkedDataPoints = linkedDataPoints;
    }
    this.charge = charge;
  }

  public DPPIsotopePatternResult(IsotopePattern value, int charge) {
    super(value);

    this.charge = charge;
  }

  public @Nullable ProcessedDataPoint[] getLinkedDataPoints() {
    return linkedDataPoints;
  }

  public void setLinkedDataPoints(@Nullable ProcessedDataPoint[] linkedDataPoints) {
    this.linkedDataPoints = linkedDataPoints;
  }

  public ProcessedDataPoint getLinkedDataPoint(int i) {
    if (linkedDataPoints != null)
      if (i < linkedDataPoints.length)
        return linkedDataPoints[i];
    return null;
  }

  public int getCharge() {
    return charge;
  }

  @Override
  public String toString() {
    return "Isotope pattern (" + getValue().getNumberOfDataPoints() + ")";
  }

  @Override
  public ResultType getResultType() {
    return ResultType.ISOTOPEPATTERN;
  }
}
