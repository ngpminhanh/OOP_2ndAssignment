package uet.oop.bomberman.entities;

import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Enermy;

public class AIMedium extends AI {
    Bomber _bomber;
    Enermy _e;

    public AIMedium(Bomber bomber, Enermy enemy) {
        _bomber = bomber;
        _e = enemy;
    }

    @Override
    public int caculateDirection() {
        int vertical = random.nextInt(2);

        if(vertical == 1) {
            if(calculateColDirection() != -1)
                return calculateColDirection();
            else
                return calculateRowDirection();

        } else {
            if(calculateRowDirection() != -1)
                return calculateRowDirection();
            else
                return calculateColDirection();
        }
//        else {
//            return random.nextInt(4);
//        }

    }

    protected int calculateColDirection() {
        if(_bomber.getX() < _e.getX())
            return 3;
        else if(_bomber.getX() > _e.getX())
            return 1;

        return -1;
    }

    protected int calculateRowDirection() {
        if (_bomber.getY() < _e.getY())
            return 0;
        else if (_bomber.getY() > _e.getY())
            return 2;
        return -1;
    }

}