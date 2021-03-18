package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2457_공주님의정원 {
	static int N;
	static List<Flower> flowers = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int stMonth = Integer.parseInt(st.nextToken());
			int stDay = Integer.parseInt(st.nextToken());
			int edMonth = Integer.parseInt(st.nextToken());
			int edDay = Integer.parseInt(st.nextToken());
			Flower flower = new Flower(stMonth, stDay, edMonth, edDay);
			if(!flowers.contains(flower)) {
				flowers.add(flower);
			}else {
				int idx= flowers.indexOf(flower);
				Flower bfFlower = flowers.get(idx);
				if(bfFlower.endDay.before(flower.endDay)) {
					flowers.set(idx, flower);
				}
			}
		}
		Date start = new Date(121,2,1);
		Date end= new Date(121,11,1);
		int result =0;
		while(start.before(end)) {
			for(int t=0;t<flowers.size();t++) {
				if(flowers.get(t).startDay.before(start)) {
					flowers.get(t).startDay = start;
				}
				if(flowers.get(t).endDay.after(end)) {
					flowers.get(t).endDay=end;
				}
				
			}
			Collections.sort(flowers, (o1,o2)->{
				if(o1.startDay.equals(o2.startDay)) {
					if(o1.endDay.after(o2.endDay)) {
						return 1;
					}else {
						return -1;
					}
				}else if(o1.startDay.before(o2.startDay)) {
					return -1;
				}else {
					return 1;
				}
				
				
			});
			boolean findStart = false;
			int stIdx;
			for(stIdx=0;stIdx<flowers.size();stIdx++) {
				Flower f = flowers.get(stIdx);
				if(f.startDay.after(start)) {
					break;
				}
				findStart = true;
				
			}
			if(!findStart) {
				result =0;
				break;
			}
			
			start = flowers.get(--stIdx).endDay;
			result++;
			if(!start.before(end)) {
				
				break;
			}
			for(int i=0;i<=stIdx;i++) {
				flowers.remove(0);
			}
			
			Collections.sort(flowers, (o1,o2)->{
				if(o1.endDay.equals(o2.endDay)) {
					if(o1.startDay.after(o2.startDay)) {
						return -1;
					}else {
						return 1;
					}
				}else if(o1.endDay.after(o2.endDay)) {
					return -1;
				}else {
					return 1;
				}
				
				
			});
			
			boolean findEnd = false;
			int edIdx;
			for(edIdx=0;edIdx<flowers.size();edIdx++) {
				Flower f = flowers.get(edIdx);
				if(f.endDay.before(end)) {
					break;
				}
				findEnd = true;
				
			}
			if(!findEnd) {
				result =0;
				break;
			}
			end = flowers.get(--edIdx).startDay;
			for(int i=0;i<=edIdx;i++) {
				flowers.remove(0);
			}
			result++;
		}
		System.out.println(result);
		return;
	}
	
	static class Flower{
		
		Date startDay, endDay;
		public Flower(int startMonth, int startDay, int endMonth, int endDay) {
			super();
			
			this.startDay = new Date(121, startMonth-1, startDay);
			this.endDay = new Date(121,endMonth-1,endDay);
			
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((startDay == null) ? 0 : startDay.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Flower other = (Flower) obj;
			if (startDay == null) {
				if (other.startDay != null)
					return false;
			} else if (!startDay.equals(other.startDay))
				return false;
			return true;
		}

		@Override
		public String toString() {
			
			return (startDay.getMonth()+1)+"/"+startDay.getDate()+" "+(endDay.getMonth()+1)+"/"+endDay.getDate();
		}
		
	}
}
