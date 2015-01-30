package net.rystuff.mcjsonsound;

import com.google.gson.stream.JsonWriter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MCJsonSound
{
    public static String modid;
    public static String directory;
    public static File file;
    public static String[] ext;
    public static Collection files;
    public static String dir;
    public static String[] dirs;
    public static List<String> listDirs = new ArrayList<String>();
    public static List<String> listNames = new ArrayList<String>();
    public static String[] names;
    public static String name;
    public static String lastName = null;
    public static JsonWriter writer;
    public static int testing;

    public static void main(String[] args)
    {
        try
        {
            modid = args[0];
            writer = new JsonWriter(new FileWriter(args[2]));
            directory = args[1];
            file = new File(directory);
            ext = new String[]{"ogg"};
            files = FileUtils.listFiles(file, ext, true);
            for (Object path : files)
            {
                path = StringUtils.replace(path.toString(), "\\", "/");
                path = StringUtils.substringAfter(path.toString(), "sounds/");
                dir = StringUtils.replace(path.toString(), ".ogg", "");
                listDirs.add(dir);
                names = dir.split("/");
                if (names.length == 3)
                {
                    name = dir.split("/")[1];
                    if (!name.equals(lastName))
                    {
                        listNames.add(name);
                    }
                    lastName = name;
                }
                if (names.length == 1)
                {
                    name = dir;
                    if (!name.equals(lastName))
                    {
                        listNames.add(name);
                    }
                    lastName = name;
                }
            }
            dirs = new String[listDirs.size()];
            dirs = listDirs.toArray(dirs);
            names = new String[listNames.size()];
            names = listNames.toArray(names);
            System.out.println(Arrays.toString(dirs));
            System.out.println(Arrays.toString(names));
            writer.beginObject();
            writer.setIndent("    ");
            for (String name : names)
            {
                name = name.toLowerCase();
                if (name.contains("living"))
                {
                    writer.name(modid + ":"  + name + ":"  + "living");
                    writer.beginObject();
                    writer.name("category").value("hostile");
                    writer.name("sounds").beginArray();
                    for (String dir : dirs)
                    {
                        if (dir.contains(name))
                        {
                            writer.value(dir);
                        }
                    }
                    writer.endArray();
                    writer.endObject();
                }
                if (name.contains("hurt"))
                {
                    writer.name(modid + ":"  + name + ":"  + "hurt");
                    writer.beginObject();
                    writer.name("category").value("hostile");
                    writer.name("sounds").beginArray();
                    for (String dir : dirs)
                    {
                        if (dir.contains(name))
                        {
                            writer.value(dir);
                        }
                    }
                    writer.endArray();
                    writer.endObject();
                }
                if (name.contains("death"))
                {
                    writer.name(modid + ":"  + name + ":"  + "death");
                    writer.beginObject();
                    writer.name("category").value("hostile");
                    writer.name("sounds").beginArray();
                    for (String dir : dirs)
                    {
                        if (dir.contains(name))
                        {
                            writer.value(dir);
                        }
                    }
                    writer.endArray();
                    writer.endObject();
                }
                writer.name(modid + ":"  + name);
                writer.beginObject();
                writer.name("category").value("hostile");
                writer.name("sounds").beginArray();
                for (String dir : dirs)
                {
                    if (dir.contains(name))
                    {
                        writer.value(dir);
                    }
                }
                writer.endArray();
                writer.endObject();
            }
            writer.endObject();
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}