
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mikkelmoerch
 */
public class Preferences {
    private File playerDir = new File("./playerfiles");
    
    public void setPlayerDir(String path){
        this.playerDir = new File(path);
    }
    
    public File getPlayerDir(){
        return this.playerDir;
    }
    
}
