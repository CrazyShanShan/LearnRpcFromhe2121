package org.crazys.client;

import org.crazys.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

/***
 * @Description: ""
 * @Author: ZBZ
 * @Date: 2021/5/28
 */
public class MyRPCClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream.writeInt(new Random().nextInt());
            objectOutputStream.flush();
            Object o = objectInputStream.readObject();
            User user = (User) o;
            System.out.println("服务器端返回了一个User"+user);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
