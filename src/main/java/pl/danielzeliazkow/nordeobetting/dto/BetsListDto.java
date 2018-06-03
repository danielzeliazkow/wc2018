package pl.danielzeliazkow.nordeobetting.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import pl.danielzeliazkow.nordeobetting.db.entity.MatchBet;

public class BetsListDto  {
	
	@Valid
    private List<MatchBet> list;

    public BetsListDto() {
       this.list = new ArrayList<MatchBet>();
    }

    public BetsListDto(List<MatchBet> list) {
        this.list = list;
    }

    public List<MatchBet> getList() {
        return list;
    }

    public void setList(List<MatchBet> list) {
        this.list = list;
    }
}
