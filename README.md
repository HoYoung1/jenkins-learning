# Jenkins CI/CD 학습 프로젝트

이 프로젝트는 Jenkins를 처음 배우는 분들을 위한 Hello World 예제입니다.

## 프로젝트 구조

```
jenkins-learning/
├── hello-world.py          # 메인 애플리케이션
├── test_hello_world.py     # 테스트 파일
├── requirements.txt        # Python 의존성
├── Jenkinsfile            # Jenkins 파이프라인 정의
├── JENKINS_SETUP.md       # Jenkins 설치 및 설정 가이드
└── README.md              # 이 파일
```

## 로컬에서 실행하기

### 1. 애플리케이션 실행
```bash
python3 hello-world.py
```

### 2. 테스트 실행
```bash
python3 -m unittest test_hello_world.py
```

## Jenkins 파이프라인

이 프로젝트는 Jenkins 파이프라인을 통해 다음 단계들을 자동화합니다:

1. **Checkout**: 소스 코드 체크아웃
2. **Build**: 애플리케이션 빌드
3. **Test**: 테스트 실행
4. **Deploy**: 배포 (선택사항)

## 학습 목표

- [x] 기본 Python 애플리케이션 생성
- [x] 테스트 코드 작성
- [x] Jenkinsfile 작성
- [x] Jenkins 설치 가이드 작성
- [ ] Jenkins 설치 및 설정
- [ ] CI/CD 파이프라인 구축
- [ ] 자동화된 빌드 및 테스트

## 다음 단계

1. **Jenkins 설치**: `JENKINS_SETUP.md` 파일을 참고하여 Jenkins를 설치하세요
2. **GitHub 저장소 생성**: 프로젝트를 GitHub에 푸시하세요
3. **Jenkins 파이프라인 구성**: Jenkins에서 파이프라인을 생성하고 실행하세요
4. **자동화된 빌드 및 테스트**: CI/CD 파이프라인이 자동으로 작동하는지 확인하세요

## 빠른 시작

```bash
# 1. 로컬에서 테스트
python3 hello-world.py
python3 -m unittest test_hello_world.py -v

# 2. Git 저장소 초기화
git init
git add .
git commit -m "Initial commit: Jenkins Hello World project"

# 3. Jenkins 설치 (JENKINS_SETUP.md 참고)
``` 