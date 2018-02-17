package digital.wup.superhero.domain.usecase;


import digital.wup.superhero.domain.Request;

public class GetCharacterRequest implements Request {
    private String characterId;

    public GetCharacterRequest() {

    }

    public GetCharacterRequest(String characterId) {
        this.characterId = characterId;
    }

    public String getCharacterId() {
        return characterId;
    }

    public void setCharacterId(String characterId) {
        this.characterId = characterId;
    }
}
