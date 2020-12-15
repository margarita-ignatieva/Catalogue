package by.intexsoft.ignatieva;

import by.intexsoft.ignatieva.model.Directory;
import by.intexsoft.ignatieva.service.FindDirectoryChildren;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String... args) {
        Directory dir1 = new Directory();
        dir1.setId(1);
        dir1.setParentId(0);
        Directory dir2 = new Directory();
        dir2.setId(2);
        dir2.setParentId(3);
        Directory dir3 = new Directory();
        dir3.setId(3);
        dir3.setParentId(1);
        Directory dir4 = new Directory();
        dir4.setId(4);
        dir4.setParentId(3);
        Directory dir5 = new Directory();
        dir5.setId(5);
        dir5.setParentId(1);
        List<Directory> allDirs = new ArrayList<>();
        allDirs.add(dir1);
        allDirs.add(dir2);
        allDirs.add(dir3);
        allDirs.add(dir4);
        allDirs.add(dir5);
        allDirs.stream().flatMap(x -> x.getChildren().stream())
                .forEach(System.out::println);
        FindDirectoryChildren.fillInChildren(allDirs);
        allDirs.stream().flatMap(x -> x.getChildren().stream())
                .forEach(System.out::println);
    }
}
