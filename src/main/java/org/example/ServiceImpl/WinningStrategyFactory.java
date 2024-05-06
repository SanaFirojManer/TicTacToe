package org.example.ServiceImpl;

import org.example.Model.Enum.WinningStrategyName;
import org.example.Service.WinningStratergiy.WinningStrategy;

public class WinningStrategyFactory {
    public static WinningStrategy getWinningStratergy(WinningStrategyName names, int dimension ){
        return new OrderOneWinningStratergy(dimension);
    }
}
