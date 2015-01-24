package net.rystuff.mcjsonsound;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        String directory = args[0];
        File file = new File(directory);
        String[] ext = {"ogg"};
        Collection files = FileUtils.listFiles(file, ext, true);
        String dir;
        String[] names;
        String name;
        StringBuilder stringBuilder = new StringBuilder();
        String last = null;
        for (Object path:files)
        {
            path = StringUtils.replace(path.toString(), "\\", "/");
            path = StringUtils.substringAfter(path.toString(), "sounds/");
            dir = StringUtils.replace(path.toString(), ".ogg", "");
            System.out.println(path);
            //name = path.toString().substring(path.toString().lastIndexOf("/")+1);
            names = path.toString().split("/");
            if (names[0].equals("bells.ogg"))
                System.out.println(names.length);
            if (last == null)
                stringBuilder.append("{\n");
            if (names.length != 1 && last != null && ! names[1].equals(last))
            {
                stringBuilder.append("\n");
                stringBuilder.append("      ]\n");
                stringBuilder.append("  },\n");
            }
            if (names.length != 1 && !names[1].equals(last))
            {
                if (!(names.length < 3))
                {
                    if (!names[1].equals(last))
                        System.out.println(names[1]);
                    stringBuilder.append("  \"" + names[1] + "\":\n");
                    last = names[1];
                }
                stringBuilder.append("  {\n");
                stringBuilder.append("      \"category\":\"hostile\",\n");
                stringBuilder.append("      \"sounds\":\n");
                stringBuilder.append("      [\n");
                stringBuilder.append("          \"" + dir + "\"");
            } else if (names.length == 1) {
                System.out.println("its 1");
                if (last != null)
                {
                    stringBuilder.append("\n");
                    stringBuilder.append("      ]\n");
                    stringBuilder.append("  },\n");
                }
                stringBuilder.append("  \"" + dir + "\":\n");
                stringBuilder.append("  {\n");
                stringBuilder.append("      \"category\":\"master\",\n");
                stringBuilder.append("      \"sounds\":\n");
                stringBuilder.append("      [\n");
                stringBuilder.append("          \"" + dir + "\"");
                last = names[0];

            } else {
                stringBuilder.append(",\n");
                stringBuilder.append("          \"" + dir + "\"");
            }
        }
        stringBuilder.append("\n");
        stringBuilder.append("      ]\n");
        stringBuilder.append("  }\n");
        stringBuilder.append("}");
        try
        {
            PrintWriter out = new PrintWriter(args[1], "UTF-8");
            out.println(stringBuilder.toString());
            out.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        System.out.println(stringBuilder.toString());
    }
}