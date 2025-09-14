package org.example.Dynamo;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.util.Objects;

@DynamoDbBean
public class DBEntity {
    private String hashId;
    private String sortId;
    private String data;

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        DBEntity dbEntity = (DBEntity) object;
        return Objects.equals(getHashId(), dbEntity.getHashId())
                && Objects.equals(getSortId(), dbEntity.getSortId())
                && Objects.equals(getData(), dbEntity.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHashId(), getSortId(), getData());
    }
}