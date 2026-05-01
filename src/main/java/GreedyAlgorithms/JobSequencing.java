package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {
    // 1. Blueprint for our Job object
    static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        // jobInfo[i][0] = Deadline, jobInfo[i][1] = Profit
        int jobInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
        ArrayList<Job> jobs = new ArrayList<>();

        // 2. Wrap raw data into Job objects for easier sorting
        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }
        // 3. Greedy Choice: Sort jobs by Profit in DESCENDING order
        // We want the most money first!

        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;

        /*
         * NOTE: Your current logic below works only if all jobs take 1 unit
         * and we check them sequentially.
         * A more robust way is using a "Time Slot" array to track occupied slots.
         */

        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) { // If current time is before the deadline
                seq.add(curr.id);
                time++;
            }
        }
        // 4. Output the results

        System.out.println("Max Jobs: " + seq.size());
        for (Integer jobId : seq) {
            System.out.print(jobId + " ");
        }
        System.out.println();
    }
}