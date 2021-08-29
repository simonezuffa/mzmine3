/*
 * Copyright 2006-2021 The MZmine Development Team
 *
 * This file is part of MZmine.
 *
 * MZmine is free software; you can redistribute it and/or modify it under the terms of the GNU
 * General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * MZmine is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with MZmine; if not,
 * write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 */

package io.github.mzmine.modules.io.import_rawdata_netcdf;

import java.io.File;
import java.util.List;
import io.github.mzmine.parameters.Parameter;
import io.github.mzmine.parameters.impl.SimpleParameterSet;
import io.github.mzmine.parameters.parametertypes.filenames.FileNamesParameter;
import io.github.mzmine.util.ExitCode;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class NetCDFImportParameters extends SimpleParameterSet {

  private static final List<ExtensionFilter> extensions = List.of( //
      new ExtensionFilter("netCDF files", "*.cdf", "*.CDF", "*.netcdf", "*.nc"), //
      new ExtensionFilter("All files", "*.*") //
  );

  public static final FileNamesParameter fileNames =
      new FileNamesParameter("File names", "", extensions);

  public NetCDFImportParameters() {
    super(new Parameter[] {fileNames});
  }

  @Override
  public ExitCode showSetupDialog(boolean valueCheckRequired) {

    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Import raw data files");
    fileChooser.getExtensionFilters().addAll(extensions);

    File lastFiles[] = getParameter(fileNames).getValue();
    if ((lastFiles != null) && (lastFiles.length > 0)) {
      File currentDir = lastFiles[0].getParentFile();
      if ((currentDir != null) && (currentDir.exists())) {
        fileChooser.setInitialDirectory(currentDir);
      }
    }

    List<File> selectedFiles = fileChooser.showOpenMultipleDialog(null);
    if (selectedFiles == null) {
      return ExitCode.CANCEL;
    }
    getParameter(fileNames).setValue(selectedFiles.toArray(new File[0]));

    return ExitCode.OK;

  }

}
