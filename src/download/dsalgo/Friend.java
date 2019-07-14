package download.dsalgo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Friend {
	private Collection<Friend> friends;
	private String email;

	public Friend(String email) {
		this.email = email;
		this.friends = new ArrayList<Friend>();
	}

	public String getEmail() {
		return email;
	}

	public Collection<Friend> getFriends() {
		return friends;
	}

	public void addFriendship(Friend friend) {
		friends.add(friend);
		friend.getFriends().add(this);
	}

	public boolean canBeConnected(Friend friend) {
		Set<Friend> set = new HashSet<>();
		Collection<Friend> myFriends = this.getFriends();
		addFrieds(myFriends, set);
		if(set.contains(friend)) {
			return true;
		}
		return false;
	}

	private void addFrieds(Collection<Friend> myFriends, Set<Friend> set) {
		if (myFriends != null && !myFriends.isEmpty()) {
			for (Friend friend : myFriends) {
				if (!set.contains(friend) && !friend.equals(this)) {
					set.add(friend);
					addFrieds(friend.getFriends(), set);
				}
			}

		}
	}

	public static void main(String[] args) {
		Friend a = new Friend("A");
		Friend b = new Friend("B");
		Friend c = new Friend("C");

		a.addFriendship(b);
		b.addFriendship(c);

		System.out.println(a.canBeConnected(c));
	}

	@Override
	public boolean equals(Object friend) {
		if (friend == null) {
			return false;
		}

		if (!(friend instanceof Friend)) {
			return false;
		}
		String em = ((Friend) friend).getEmail();
		if (this.email.equals(em)) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return this.email;
	}
}