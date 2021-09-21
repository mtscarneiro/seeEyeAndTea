package dio.springperson.mts.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/character")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Character>> findAll() {
        List<Character> characterList = characterService
                .findAll();
        return ResponseEntity.ok().body(characterList);
    }

    @GetMapping(value = "/por")
    public ResponseEntity<Character> findById(Integer id) {
        Character character = characterService.findById(id);
        return ResponseEntity.ok().body(character);
    }

    public ResponseEntity<Character> insert(@RequestBody Character character) {
        
    }

}
