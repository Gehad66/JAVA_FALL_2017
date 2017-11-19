package com.game.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Run {

	public static void main(String[] args) {

		try {
			ServerImpl serverImpl = new ServerImpl();
            Registry reg = LocateRegistry.createRegistry(1111);
			reg.rebind("serverService", serverImpl);
			System.out.println("The Server is Running....");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
