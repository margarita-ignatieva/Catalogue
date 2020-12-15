package by.intexsoft.ignatieva.service;

import by.intexsoft.ignatieva.model.Directory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDirectoryChildren {
    public static void fillInChildren(List<Directory> allDirectories) {
        List<Directory> tempList = new ArrayList<>();
        tempList.addAll(allDirectories);
        while (tempList.size() > 1) {
            Set<Long> allParentsIds = tempList.stream()
                    .map(Directory::getParentId)
                    .collect(Collectors.toSet());
            Set<Long> allIds = tempList.stream()
                    .map(Directory::getId)
                    .collect(Collectors.toSet());
            allIds.removeAll(allParentsIds);
            for (Long l : allIds) {
                Directory ChildDir = findById(tempList, l);
                Directory parentDir = tempList.get((int) ChildDir.getParentId());
                List<Directory> children = parentDir.getChildren();
                children.add(ChildDir);
                tempList.remove(ChildDir);
            }
        }
    }
    private static Directory findById(List<Directory> allDirectories, Long id) {
        return allDirectories.stream()
                .filter(dir -> dir.getId() == id)
                .findFirst()
                .get();
    }
}
