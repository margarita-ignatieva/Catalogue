package by.intexsoft.ignatieva.service;

import by.intexsoft.ignatieva.model.Directory;

import java.util.*;
import java.util.stream.Collectors;

public class FindDirectoryChildren {

    public static void fillInChildrenDirectories(List<Directory> allDirectories) {
        Map<Long, List<Directory>> directoriesMap = allDirectories.stream()
                .collect(Collectors.groupingBy(Directory::getParentId));
        for(Directory directory : allDirectories) {
            if (directoriesMap.containsKey(directory.getId())) {
                directory.setChildren(directoriesMap.get(directory.getId()));
            }
        }
    }

}
