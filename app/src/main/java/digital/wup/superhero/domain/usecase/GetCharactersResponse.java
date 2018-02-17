package digital.wup.superhero.domain.usecase;


import digital.wup.superhero.domain.Response;
import digital.wup.superhero.data.model.Character;

public class GetCharactersResponse implements Response {
    private Character[] characters;

    public Character[] getCharacters() {
        return characters;
    }

    public void setCharacters(Character[] characters) {
        this.characters = characters;
    }
}
