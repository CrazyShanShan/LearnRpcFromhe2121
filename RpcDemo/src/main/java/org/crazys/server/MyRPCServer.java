package org.crazys.server;

import org.crazys.common.User;
import org.omg.CORBA.Object;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/***
 * @Description: ""
 * @Author: ZBZ
 * @Date: 2021/5/28
 */
public class MyRPCServer {
    public static void main(String[] argws) {
        UserServiceImpl userService = new UserServiceImpl();

        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务端启动");
            while (true) {
                Socket socket = serverSocket.accept();
                // 开启一个县城取处理
                new Thread(() -> {
                    try {
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                        // 读取客户端传过来的id
                        Integer id = objectInputStream.readInt();
                        User user = userService.getUserByUserId(id);
                        objectOutputStream.writeObject(user);
                        objectOutputStream.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("从IO中读取数据错误");
        }
    }
}
