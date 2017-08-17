package com.isa.haozi.db;

import java.io.Serializable;

/**
 * Created by Izumi on 17/8/17.
 */

public class DBEntity implements Serializable {

    public String id;
    public String name;
    public String date;
    public String path;
    public String type;

    public DBEntity() {

    }
}
