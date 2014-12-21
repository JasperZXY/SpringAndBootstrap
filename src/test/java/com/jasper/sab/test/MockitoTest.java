package com.jasper.sab.test;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class MockitoTest {

	@SuppressWarnings("unchecked")
	@Test
	public void simpleTest() {
		// 创建mock对象，参数可以是类，也可以是接口
		List<String> list = Mockito.mock(List.class);
		// 设置方法的预期返回值
		// Mockito.when(list.get(0)).thenReturn("helloworld");
		Mockito.doReturn("helloworld").when(list).get(0);

		String result = list.get(0);
		// 验证方法调用(是否调用了get(0))
		Mockito.verify(list).get(0);

		// junit测试
		Assert.assertEquals("helloworld", result);

		// 测试异常
		Mockito.when(list.get(1)).thenThrow(new RuntimeException("test excpetion"));
		try {
			list.get(1);
			Assert.assertTrue(false);  //由于抛异常，所以不会跑这里
		} catch (Exception e) {
			Assert.assertTrue(true);   //一定会跑这段代码
			System.out.println("list.get(1):" + e.getMessage());
		}

		Mockito.doNothing().doThrow(new RuntimeException("void exception")).when(list).clear();
		list.clear();
		try {
			list.clear();
		} catch (Exception e) {
			System.out.println("list.clear():" + e.getMessage());
		}
		Mockito.verify(list, Mockito.times(2)).clear();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void argumentTest() {
		List<String> list = Mockito.mock(List.class);
		Mockito.when(list.get(Mockito.anyInt())).thenReturn("hello", "world");

		String result = list.get(0) + list.get(1);
		Mockito.verify(list, Mockito.times(2)).get(Mockito.anyInt());

		Assert.assertEquals("helloworld", result);

		Map<Integer, String> map = Mockito.mock(Map.class);
		Mockito.when(map.put(Mockito.anyInt(), Mockito.anyString())).thenReturn("hello");// anyString()替换成"hello"就会报错
		result = map.put(1, "world");
		Assert.assertEquals("hello", result);
		Mockito.verify(map).put(Mockito.eq(1), Mockito.eq("world")); // 注意这里一定要用eq
	}

	@SuppressWarnings("unchecked")
	@Test
	public void verifyTimes() {
		List<String> mockedList = Mockito.mock(List.class);
		// using mock
		mockedList.add("once");
		mockedList.add("twice");
		mockedList.add("twice");

		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");

		/**
		 * 基本的验证方法 verify方法验证mock对象是否有没有调用mockedList.add("once")方法
		 * 不关心其是否有返回值，如果没有调用测试失败。
		 */
		Mockito.verify(mockedList).add("once");
		Mockito.verify(mockedList, Mockito.times(1)).add("once");// 默认调用一次,times(1)可以省略

		Mockito.verify(mockedList, Mockito.times(2)).add("twice");
		Mockito.verify(mockedList, Mockito.times(3)).add("three times");

		// never()等同于time(0),一次也没有调用
		Mockito.verify(mockedList, Mockito.times(0)).add("never happened");

		// atLeastOnece/atLeast()/atMost()
		Mockito.verify(mockedList, Mockito.atLeastOnce()).add("three times");
		Mockito.verify(mockedList, Mockito.atLeast(2)).add("twice");
		Mockito.verify(mockedList, Mockito.atMost(5)).add("three times");
	}

}
