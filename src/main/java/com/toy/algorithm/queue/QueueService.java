package com.toy.algorithm.queue;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class QueueService {
    // TODO: qSize를 정해두고 해당 값을 infinity로 사용할 수 있도록 하라.
    private final int size = 10;
    private int inputPosition = 0;
    private int outputPosition = 0;
    private final int[] queueArray = new int[size];

    // 큐의 삽입연산
    public void enQueue(int value) {
        // 큐의 포화상태 확인, 포화상태일 때에는 더 이상 넣을 수 없음
        if (isFull()) {
            System.out.println("FULL IS TRUE");
            return;
        }

        // 추가처리
        queueArray[inputPosition] = value;
        inputPosition = inputPosition + 1;
        System.out.println("after enQueue, input is " + inputPosition);
        System.out.println("queue is " + Arrays.toString(queueArray));
    }

    public void deQueue() {
        // 큐의 공백상태 확인, 공백상태일 때에는 더 이상 삭제할 수 없음
        if (isEmpty()) {
            System.out.println("EMPTY IS TRUE");
            return;
        }

        // 값 출력
        queueArray[outputPosition] = 0;
        outputPosition = outputPosition + 1;

        System.out.println("after deQueue, input is " + inputPosition);
        System.out.println("after deQueue, output is " + outputPosition);
        System.out.println("queue is " + Arrays.toString(queueArray));
    }

    // 큐 포화상태 체크용 함수
    public boolean isFull() {
        System.out.println("CHECK FULL");
        System.out.println("END OF FULL ------------");
        System.out.println("input : " + inputPosition);
        System.out.println("output : " + outputPosition);
        if (inputPosition != 0) {
            for (int queue : queueArray) {
                if (queue == 0) {
                    System.out.println("포화상태가 아님");
                    // 포화상태가 아닌데 inputPosition이 첫번째 index값으로 돌아가야 한다면 inputPosition initialize
                    if (inputPosition == size) inputPosition = 0;
                    return false;
                }
            }
            System.out.println("초기값이 아니지만 포화상태");
            return true;
        }
        // 초기값
        return !(inputPosition == outputPosition);
    }

    // 큐 공백상태 체크용 함수
    public boolean isEmpty() {
        System.out.println("CHECK EMPTY");
        System.out.println("END OF EMPTY ------------");
        System.out.println("input : " + inputPosition);
        System.out.println("output : " + outputPosition);
        if (outputPosition != 0) {
            for (int queue : queueArray) {
                if (queue != 0) {
                    System.out.println("공백상태가 아님");
                    // 공백상태가 아닌데 outputPosition이 첫번째 index값으로 돌아가야 한다면 outputPosition initialize
                    if (outputPosition == size) outputPosition = 0;
                    return false;
                }
            }
            System.out.println("초기값이 아니지만 공백상태");
            return true;
        }
        // 초기값
        return inputPosition == outputPosition;
    }
}
