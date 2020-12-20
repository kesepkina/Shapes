package com.epam.cube.model.comparator;

import com.epam.cube.model.entity.Cube;
import com.epam.cube.model.entity.Shape3DProperties;
import com.epam.cube.model.warehouse.Shape3DPropertiesWarehouse;

import java.util.Comparator;

public enum CubeComparator implements Comparator<Cube> {

    ID {
        @Override
        public int compare(Cube o1, Cube o2) {
            return Integer.compare(o1.getId(), o2.getId());
        }
    },

    SIDE_LENGTH {
        @Override
        public int compare(Cube o1, Cube o2) {
            return Double.compare(o1.getSideLength(), o2.getSideLength());
        }
    },

    DISTANCE_FROM_CENTER_TO_ORIGIN {
        @Override
        public int compare(Cube o1, Cube o2) {
            int id1 = o1.getId();
            int id2 = o2.getId();
            Shape3DProperties properties1 = Shape3DPropertiesWarehouse.getInstance().getProperties(id1);
            Shape3DProperties properties2 = Shape3DPropertiesWarehouse.getInstance().getProperties(id2);
            return Double.compare(properties1.getDistanceFromCenterToOrigin(), properties2.getDistanceFromCenterToOrigin());
        }
    }
}
