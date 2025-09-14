package org.example;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@NoArgsConstructor
public class KeyClass {
    protected String primaryKey;
    protected String secondaryKey;
    /**
     * Takes in an id of an object, adds the identifier to the id and saves the object with
     * key being identifier#id.
     * @param identifier fixed value according to the object
     * @param id unique Id of the object
     * @return the custom key for the object
     */
    public String getKey(final String identifier, String id){
        return String.format("%s#%s", identifier, id);
    }
}
