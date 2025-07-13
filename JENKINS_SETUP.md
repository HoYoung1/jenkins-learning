# Jenkins 설치 및 설정 가이드

## 1. Jenkins 설치 (macOS)

### Homebrew를 사용한 설치 (권장)
```bash
# Homebrew 설치 (이미 설치되어 있다면 생략)
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

# Jenkins 설치
brew install jenkins-lts
```

### Docker를 사용한 설치
```bash
# Jenkins 컨테이너 실행
docker run -d \
  --name jenkins \
  -p 8080:8080 \
  -p 50000:50000 \
  -v jenkins_home:/var/jenkins_home \
  jenkins/jenkins:lts
```

## 2. Jenkins 시작

### Homebrew로 설치한 경우
```bash
# Jenkins 서비스 시작
brew services start jenkins-lts

# 또는 수동으로 시작
jenkins
```

### Docker로 설치한 경우
```bash
# 컨테이너가 이미 실행 중이므로 브라우저에서 접속
open http://localhost:8080
```

## 3. Jenkins 초기 설정

1. 브라우저에서 `http://localhost:8080` 접속
2. 초기 관리자 비밀번호 확인:
   ```bash
   # Homebrew 설치 시
   cat ~/Library/Logs/Jenkins/jenkins.log | grep password
   
   # Docker 설치 시
   docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
   ```
3. "Install suggested plugins" 선택
4. 관리자 계정 생성
5. Jenkins URL 설정 (기본값 유지)

## 4. Git 저장소 설정

### GitHub 저장소 생성
1. GitHub에서 새 저장소 생성: `jenkins-learning`
2. 로컬 저장소를 GitHub에 푸시:
   ```bash
   git init
   git add .
   git commit -m "Initial commit: Jenkins Hello World project"
   git branch -M main
   git remote add origin https://github.com/YOUR_USERNAME/jenkins-learning.git
   git push -u origin main
   ```

## 5. Jenkins 파이프라인 생성

1. Jenkins 대시보드에서 "New Item" 클릭
2. "Pipeline" 선택하고 이름 입력 (예: "jenkins-learning")
3. "OK" 클릭
4. Pipeline 섹션에서:
   - Definition: "Pipeline script from SCM" 선택
   - SCM: "Git" 선택
   - Repository URL: `https://github.com/YOUR_USERNAME/jenkins-learning.git`
   - Script Path: `Jenkinsfile`
5. "Save" 클릭

## 6. 파이프라인 실행

1. 생성된 파이프라인에서 "Build Now" 클릭
2. 빌드 진행 상황을 실시간으로 확인
3. 각 스테이지별 로그 확인 가능

## 7. 유용한 Jenkins 플러그인

- **Blue Ocean**: 시각적 파이프라인 편집기
- **GitHub Integration**: GitHub 연동
- **Pipeline Utility Steps**: 파이프라인 유틸리티
- **Timestamper**: 빌드 로그에 타임스탬프 추가

## 8. 문제 해결

### Jenkins가 시작되지 않는 경우
```bash
# Jenkins 상태 확인
brew services list | grep jenkins

# 로그 확인
tail -f ~/Library/Logs/Jenkins/jenkins.log
```

### 권한 문제
```bash
# Jenkins 홈 디렉토리 권한 확인
ls -la /usr/local/var/lib/jenkins
```

## 9. 다음 단계

- [x] Jenkins 설치 완료
- [x] GitHub 저장소 생성 및 푸시
- [x] Jenkins 파이프라인 생성
- [x] 첫 번째 빌드 실행
- [x] Freestyle Project (배치 작업 스케줄링)
- [x] Multibranch Pipeline (다중 브랜치 자동 감지)
- [ ] 파이프라인 최적화 (병렬 처리, 조건부 실행)
- [ ] Blue Ocean UI (시각적 파이프라인 편집기)
- [ ] 알림 설정 (이메일, Slack 등) 