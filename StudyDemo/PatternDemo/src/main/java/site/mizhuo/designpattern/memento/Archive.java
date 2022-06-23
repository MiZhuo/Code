package site.mizhuo.designpattern.memento;

/**
 * @ClassName Archive
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-11 22:31
 * @Version 1.0
 **/
public class Archive {
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Game saveArchive(){
        return new Game(status);
    }

    public void getStatusFromArchive(Game game){
        this.status = game.getStatus();
    }
}
