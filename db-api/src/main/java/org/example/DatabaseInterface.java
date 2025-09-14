package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

@Service
public interface DatabaseInterface {
    ObjectMapper objectMapper = SpringConfiguration.getMapper();
    /**
     * @param key unique key object for identifier in the database, contains hash and sort key
     * @param type reference class of the object present
     * @return the object if found in the database
     * @param <T> the type of object the method is dealing with
     */
    public <T> T get(final KeyClass key, final Class<T> type);

    /**
     * @param key unique key object for identifier in the database, contains hash and sort key
     * @param type reference class of the object present
     * @return the list of objects if found in the database
     * @param <T> the type of object the method is dealing with
     */
    public <T> List<T> get(final KeyClass key, final TypeReference<List<T>> type);

    /**
     * @param object the item to be saved
     * @param key unique key object for identifier in the database, contains hash and sort key
     * @param type reference class of the object present
     * @param <T> the type of object the method is dealing with
     */
    public <T> void save(final T object, final KeyClass key, final Class<T> type);

    /**
     * @param objects  the list of items to be saved
     * @param key unique key object for identifier in the database, contains hash and sort key
     * @param type reference class of the object present
     * @param <T> the type of object the method is dealing with
     */
    public <T> void save(final List<T> objects, final KeyClass key, final TypeReference<List<T>> type);

    /**
     * @param key unique key object for identifier in the database, contains hash and sort key
     */
    public void delete(KeyClass key);

    static <T> T transform(final String data, final Class<T> type){
        try{
            return objectMapper.readValue(data, type);
        } catch (final IOException err){
            throw new UncheckedIOException("unable to convert data into the mentioned object instance", err);
        }
    }

    static <T> List<T> transform(final String data, final TypeReference<List<T>> type){
        try{
            return objectMapper.readValue(data, type);
        } catch (final IOException err){
            throw new UncheckedIOException("unable to convert data into the mentioned object instance", err);
        }
    }

    static String transform(Object object){
        try{
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException err){
            throw new ClassCastException("Unable to remove null values from the object");
        }
    }
}
