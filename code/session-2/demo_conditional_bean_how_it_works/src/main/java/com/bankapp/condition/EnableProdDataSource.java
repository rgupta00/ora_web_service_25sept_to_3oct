package com.bankapp.condition;
public class EnableProdDataSource implements DataSourceConfig{

    @Override
    public void makeConnection() {
        System.out.println("Connection established to prod data..");

    }
}
