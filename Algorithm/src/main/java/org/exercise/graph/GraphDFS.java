package org.exercise.graph;

import java.util.List;

public class GraphDFS {

    /**
     * leetcdoe739 每日温度
     */
    boolean[] vis;
    int num;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        vis = new boolean[n];
        num = 0;
        dfs(rooms, 0);
        return n==num;
    }

    public void dfs(List<List<Integer>> rooms, int x) {
        vis[x] = true;
        num++;
        for (int nextRoom : rooms.get(x)) {
            if (!vis[nextRoom]) {
                dfs(rooms, nextRoom);
            }
        }
    }


}
