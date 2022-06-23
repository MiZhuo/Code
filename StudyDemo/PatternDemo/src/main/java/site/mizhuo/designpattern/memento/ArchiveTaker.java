package site.mizhuo.designpattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ArchiveTaker
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-11 22:35
 * @Version 1.0
 **/
public class ArchiveTaker {
    private List<Game> games = new ArrayList<>();

    public void add(Game game){
        games.add(game);
    }

    public Game getGame(int index){
        return games.get(index);
    }
}
