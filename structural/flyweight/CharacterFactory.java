package structural.flyweight;

import java.util.HashMap;
import java.util.Map;

class CharacterFactory {
    private static Map<String, CharacterType> characterTypes = new HashMap<>();

    public static CharacterType getCharacterType(String name, String weapon, String armor) {
        String key = name + weapon + armor;
        CharacterType type = characterTypes.get(key);
        
        if (type == null) {
            type = new CharacterType(name, weapon, armor);
            
            characterTypes.put(key, type);
        }
        
        return type;
    }
}
