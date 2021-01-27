package by.intexsoft.ignatieva.service;

import by.intexsoft.ignatieva.model.Directory;

import java.util.*;
import java.util.stream.Collectors;

public class FindDirectoryChildren {
    public static void fillInChildrenDirectories(List<Directory> allDirectories) {
        Map<Long, List<Directory>> directoriesMap = new HashMap<>();
        for(Directory directory : allDirectories) {
            long parentId = directory.getParentId();
            directoriesMap.put(parentId, findChildrenDirectories(parentId, allDirectories));
        }
        for(Directory directory : allDirectories) {
            if (directoriesMap.containsKey(directory.getId())) {
                directory.setChildren(directoriesMap.get(directory.getId()));
            }
        }
    }


    private static List<Directory> findChildrenDirectories(Long parentId, List<Directory> allDirectories) {
        return allDirectories.stream().filter(directory -> directory.getParentId() == parentId)
                .collect(Collectors.toList());
    }

}
