package org.example.ServiceImpl;

import org.example.Model.Enum.WinningStrtergyNames;
import org.example.Service.WinningStratergiy.WinningStrategy;

public class WinningStratergyFactory {
    public static WinningStrategy getWinningStratergy(WinningStrtergyNames names, int dimension ){
        return new OrderOneWinningStratergy(dimension);
    }
}
