package digital.wup.superhero.domain.usecase;


import digital.wup.superhero.data.model.Character;
import digital.wup.superhero.domain.Response;

public class GetCharacterResponse implements Response {
    private Character character;

    public GetCharacterResponse() {

    }

    public GetCharacterResponse(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
