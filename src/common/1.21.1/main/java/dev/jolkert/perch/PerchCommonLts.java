package dev.jolkert.perch;

public class PerchCommonLts
{
	public static void init()
	{
		Perch.init(player -> !(player.getShoulderEntityRight().isEmpty() && player.getShoulderEntityLeft().isEmpty()));
	}
}
