package by.intexsoft.ignatieva.model;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private long id;
    private long parentId;
    private List<Directory> children = new ArrayList<>(0);

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public List<Directory> getChildren() {
        return children;
    }

    public void setChildren(List<Directory> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "id=" + id +
                ", parentId=" + parentId +
                '}';
    }
}
