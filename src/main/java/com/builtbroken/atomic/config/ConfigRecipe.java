package com.builtbroken.atomic.config;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/20/2018.
 */
public class ConfigRecipe
{
    //-----------------------------------
    //-----Extractor
    //-----------------------------------
    public static int WATER_USED_YELLOW_CAKE = 1000;
    public static int LIQUID_WASTE_PRODUCED_YELLOW_CAKE = 1000;
    public static int YELLOW_CAKE_PER_ORE = 3;

    //-----------------------------------
    //-----Boiler
    //-----------------------------------
    public static int WATER_BOIL_YELLOWCAKE = 1000;
    public static int WATER_BOIL_URANIUM_ORE = 1000;

    public static int HEX_OUT_YELLOWCAKE = 250;
    public static int HEX_OUT_URANIUM_ORE = 600;

    public static int CON_WATER_YELLOWCAKE = 1000;
    public static int CON_WATER_URANIUM_ORE = 1000;

    public static int LIQUID_WASTE_PRODUCED_TO_WATER = 1;
    public static int LIQUID_WASTE_CONSUMED_PER_BOIL = 1000;
    public static int LIQUID_WASTE_SOLID_WASTE = 1;

    public static int SOLID_WASTE_YELLOWCAKE = 1; //TODO maybe make a % of an item, with progress bar to full item
    public static int SOLID_WASTE_URANIUM_ORE = 3; //TODO maybe make a % of an item, with progress bar to full item

    //-----------------------------------
    //-----Centrifuge
    //-----------------------------------
    public static int URANIUM_HEX_PER_CENTRIFUGE = 200;
    public static int MINERAL_WASTE_WATER_PER_CENTRIFUGE = 1000;
    public static int MINERAL_WASTE_WATER_PER_WATER = 1;
    public static int SOLID_WASTE_PER_CENTRIFUGE = 1;
}
