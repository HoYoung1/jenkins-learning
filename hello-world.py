#!/usr/bin/env python3
"""
Jenkins CI/CD 학습을 위한 간단한 Hello World 애플리케이션
"""

def main():
    print("Hello, Jenkins World!")
    print("이 애플리케이션은 Jenkins 파이프라인으로 빌드됩니다.")
    print("자동화 테스트: 코드 변경 감지 확인! 🚀")
    print("🌿 DEVELOP 브랜치에서 실행 중입니다!")
    
    # 간단한 계산 예제
    numbers = [1, 2, 3, 4, 5]
    total = sum(numbers)
    print(f"숫자들의 합: {numbers} = {total}")
    
    return 0

if __name__ == "__main__":
    exit(main()) 