/*
 *  Copyright 2006-2020 The MZmine Development Team
 *
 *  This file is part of MZmine.
 *
 *  MZmine is free software; you can redistribute it and/or modify it under the terms of the GNU
 *  General Public License as published by the Free Software Foundation; either version 2 of the
 *  License, or (at your option) any later version.
 *
 *  MZmine is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 *  the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 *  Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with MZmine; if not,
 *  write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301
 *  USA
 */

package tdfimportest;

import io.github.mzmine.modules.dataprocessing.id_ccscalc.CCSUtils;
import io.github.mzmine.modules.io.import_bruker_tdf.TDFUtils;
import java.util.logging.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CCSTest {

  private static Logger logger = Logger.getLogger(CCSTest.class.getName());

  @Disabled("Needs test file?")
  @Test
  void testTims() {

    logger.info("CCS: " + TDFUtils.calculateCCS(1 / 1.376e-4, 1L, 322) + "");
    logger.info("CCS: " + CCSUtils.calcCCSFromTimsMobility(0.882, 2, 601.97) + "");

  }

}