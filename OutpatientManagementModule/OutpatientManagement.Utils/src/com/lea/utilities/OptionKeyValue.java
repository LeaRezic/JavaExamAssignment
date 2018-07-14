/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.utilities;

/**
 *
 * @author Lea
 */
public class OptionKeyValue {

    int key;
    String value;

    public OptionKeyValue(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OptionKeyValue) {
            OptionKeyValue okv = (OptionKeyValue) obj;
            return (this.key == okv.key);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.key;
        return hash;
    }

}
