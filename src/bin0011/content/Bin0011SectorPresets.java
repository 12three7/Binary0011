package bin0011.content;

import mindustry.ctype.*;
import mindustry.type.*;

import static bin0011.content.Bin0011Planets;

public class Bin0011SectorPresets implements ContentList {
    public static SectorPreset
    dis00;

    @Override
    public void load(){
        //reg displan
        dis00 = new SectorPreset("dis00", displan, 15){{
            captureWave = 30;
            difficulty = 3;
        }};
        // end displan
    }
}
