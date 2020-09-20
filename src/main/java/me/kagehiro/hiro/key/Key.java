package me.kagehiro.hiro.key;

public class Key {



    public int toKeyCode(String stringKey) {

        int intKey;

        switch(stringKey.toLowerCase()) {
            case "^":
                intKey = 220;
                break;
            case "1":
                intKey = 49;
                break;
            case "2":
                intKey = 50;
                break;
            case "3":
                intKey = 51;
                break;
            case "4":
                intKey = 52;
                break;
            case "5":
                intKey = 53;
                break;
            case "6":
                intKey = 54;
                break;
            case "7":
                intKey = 55;
                break;
            case "8":
                intKey = 56;
                break;
            case "9":
                intKey = 57;
                break;
            case "0":
                intKey = 48;
                break;
            case "ß":
                intKey = 219;
                break;
            case "´":
                intKey = 221;
                break;
            case "q":
                intKey = 81;
                break;
            case "w":
                intKey = 87;
                break;
            case "e":
                intKey = 69;
                break;
            case "r":
                intKey = 82;
                break;
            case "t":
                intKey = 84;
                break;
            case "z":
                intKey = 90;
                break;
            case "u":
                intKey = 85;
                break;
            case "i":
                intKey = 73;
                break;
            case "o":
                intKey = 79;
                break;
            case "p":
                intKey = 80;
                break;
            case "ü":
                intKey = 186;
                break;
            case "+":
                intKey = 187;
                break;
            case "a":
                intKey = 65;
                break;
            case "s":
                intKey = 83;
                break;
            case "d":
                intKey = 68;
                break;
            case "f":
                intKey = 70;
                break;
            case "g":
                intKey = 71;
                break;
            case "h":
                intKey = 72;
                break;
            case "j":
                intKey = 74;
                break;
            case "k":
                intKey = 75;
                break;
            case "l":
                intKey = 76;
                break;
            case "ö":
                intKey = 192;
                break;
            case "ä":
                intKey = 222;
                break;
            case "#":
                intKey = 191;
                break;
            case "<":
                intKey = 226;
                break;
            case "y":
                intKey = 89;
                break;
            case "x":
                intKey = 88;
                break;
            case "c":
                intKey = 67;
                break;
            case "v":
                intKey = 86;
                break;
            case "b":
                intKey = 66;
                break;
            case "n":
                intKey = 78;
                break;
            case "m":
                intKey = 77;
                break;
            case ",":
                intKey = 188;
                break;
            case ".":
                intKey = 190;
                break;
            case "-":
                intKey = 189;
                break;
            default:
                throw new IllegalArgumentException("Illegal string: " + stringKey);
        }
        return intKey;
    }

}
