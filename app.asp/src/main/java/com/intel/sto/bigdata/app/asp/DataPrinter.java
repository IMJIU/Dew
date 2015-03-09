package com.intel.sto.bigdata.app.asp;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.intel.sto.bigdata.app.asp.util.Util;

public class DataPrinter {

  public static String print(Properties conf, Map<String, Long> workresult) throws Exception {
    Date date = new Date(System.currentTimeMillis());
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    String time = sdf.format(date);
    String output = Util.buildOutputPath(conf);
    FileWriter fw = null;
    try {
      fw = new FileWriter(new File(output, time));
      for (Entry<String, Long> entry : workresult.entrySet()) {
        fw.write(entry.getKey() + "=" + entry.getValue() + System.getProperty("line.separator"));
      }
    } finally {
      if (fw != null) {
        fw.close();
      }
    }
    return time;
  }
}
