package main.Interval;

import java.util.Arrays;

public class MeetingRooms {
	public static void main(String[] args) {
		int[][] intervals = {{0,5},{5,10},{15,20},{20,100000}};
		System.out.println(canAttendMeetings(intervals));
	}
	
	public static boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> (a[0]-b[0]));
		for(int i = 0; i < intervals.length; i++) {
			if(i < intervals.length - 1 && intervals[i][1] > intervals[i+1][0]) return false;
		}
		return true;
	}
}
