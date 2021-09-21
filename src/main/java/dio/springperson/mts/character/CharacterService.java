package dio.springperson.mts.character;

import dio.springperson.mts.exceptions.DatabaseViolationException;
import dio.springperson.mts.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    public Character findById(Integer id) {
        return characterRepository.getById(id);
    }

    public Character insert(Character character) {
        return characterRepository.save(character);
    }

    public void deleteById(Integer id) {
        try {
            characterRepository.deleteById(id);
        } catch (EmptyResultDataAccessException err) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException err) {
            throw new DatabaseViolationException(err.getMessage());
        }
    }

    private void updateAllCharacterData(Character oldCharacter, Character newCharacter) {
        oldCharacter.setName(newCharacter.getName());
        oldCharacter.setRole(newCharacter.getRole());
        oldCharacter.setHouseId(newCharacter.getHouseId());
        oldCharacter.setSchool(newCharacter.getSchool());
    }

    public Character updateData(Integer id, Character character) {
        Character charac = characterRepository.getById(id);
        updateAllCharacterData(charac, character);
        return characterRepository.save(charac);
    }

}
