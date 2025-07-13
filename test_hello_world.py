#!/usr/bin/env python3
"""
Hello World 애플리케이션의 테스트 파일
"""

import unittest
import subprocess
import sys
import os

class TestHelloWorld(unittest.TestCase):
    
    def test_main_function(self):
        """hello-world.py가 정상적으로 실행되는지 테스트"""
        try:
            result = subprocess.run([sys.executable, 'hello-world.py'], 
                                  capture_output=True, text=True, cwd=os.path.dirname(__file__))
            self.assertEqual(result.returncode, 0)
            self.assertIn("Hello, Jenkins World!", result.stdout)
        except Exception as e:
            self.fail(f"hello-world.py 실행 중 오류 발생: {e}")
    
    def test_file_exists(self):
        """hello-world.py 파일이 존재하는지 테스트"""
        file_path = os.path.join(os.path.dirname(__file__), 'hello-world.py')
        self.assertTrue(os.path.exists(file_path), f"파일이 존재하지 않습니다: {file_path}")

if __name__ == "__main__":
    unittest.main() 