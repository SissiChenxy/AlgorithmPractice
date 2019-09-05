package MockInterview;

import java.util.*;

public class MinMeetingRoom {
    static class Meeting {
        int start;
        int end;

        public Meeting(int s, int e) {
            start = s;
            end = e;
        }
    }

    // return if a person can attend all the meetings or not
    public static boolean checkMeetings(List<Meeting> meetings) {
        if(meetings == null || meetings.size() <= 1){
            return true;
        }

        //sort the list by start time
        Collections.sort(meetings, new Comparator<Meeting>(){

            public int compare(Meeting m1, Meeting m2){
                if(m1.start == m2.start){
                    return 0;
                }
                return m1.start < m2.start ? -1 : 1;
            }
        });

        //iterate the list to see whether there is overlap between two continuous meeting
        for(int i = 1; i < meetings.size(); i++){
            if(meetings.get(i-1).end > meetings.get(i).start){
                return false;
            }
        }

        return true;
    }

    // how many meeting rooms at least are required to host all those meetings
    public static int minMeetingRoomRequired(List<Meeting> meetings) {
        // [1, 2] [3, 6] [5, 7] -> 2
        // [1, 2] [3, 4] -> 1
        //data structure: hashmap<key = roomid, value = end of current meeting>
    /*algorithm:

    map = <1, 6> <2, 7>... <100, 1000>
    total -> total num of rooms
    available room -> for a given meeting room currently iterated,

    availbe <= total - 1 if any meeting remained

    slow/fast pointer

    m1, m2, m3... m10, m11
        s               f
         <1,2> <2,4> <3,6> <5,7>

array[i]   7 6

array[i] index == room, array[i] --- last endtime

      1. sort list by start time
      2. for each meet
        iterate hashmap's values
          if start time > end time, assign this meeting to the room --- update the value of the item
          if start time < all end time, assign this meeting to a new room --- map.put();



    start, end = list([]), list([])
    for i in interval_list:
        start.append(i.start)
        end.append(i.end)
    start.sort()
    end.sort()


    available = total = i = j = 0
    # 需要排序是因为要有一个同一的时间来对比不同会议之间结束和开始的关系
    # i和j分别是start和end的指针，遍历所有的start时间
    # 1）如果j结束前i开始了，有冲突，start[i] < end[j]，需要安排一个会议室
    #    如果没有available的room，需要寻找一个新的，总数+1，否则available-1，挪动i
    #    即便刚好start和end的i位置指向的是同一个meeting，那么肯定也是一个新的meeting，需要安排一个room
    # 2）否则j结束后i才开始，无冲突，start[i] >= end[j]，一个meeting结束了，available+1
    while i < len(start):
        if start[i] < end[j]:
            if available > 0:
                available -= 1
            else:
                total += 1
            i += 1
        else:
            available += 1
            j += 1
    return total

    */
        if(meetings == null || meetings.size() == 0){
            return 0;
        }


        //sort the list by start time
        int[] startTimes = new int[meetings.size()];
        int[] endTimes = new int[meetings.size()];

        for(int i = 0; i < meetings.size(); i++){
            startTimes[i] = meetings.get(i).start;
            endTimes[i] = meetings.get(i).end;
        }

        //O(nlogn)
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int start = 0;
        int end = 0;
        int total = 0;
        int available = 0;
        while(start < startTimes.length && end < endTimes.length){
            if(startTimes[start] >= endTimes[end]){
                available++;
                end++;
            }else{
                if(available > 0){
                    available--;
                }else{
                    total++;
                }
                start++;
            }
        }
        return total;
    }


    public static void test1(){
        Meeting m1 = new Meeting(1, 2);
        Meeting m2 = new Meeting(3, 6);
        Meeting m3 = new Meeting(7, 9);
        Meeting m4 = new Meeting(2, 3);
        List<Meeting> list = new ArrayList<>();
        list.add(m2);
        list.add(m1);
        list.add(m3);
        list.add(m4);
        list.add(new Meeting(8, 12));
        list.add(new Meeting(8, 12));
        list.add(new Meeting(8, 12));
        System.out.print(minMeetingRoomRequired(list));

    }
}
