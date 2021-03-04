let index = {
		//let_this=this; //function으로 사용시
		init:function(){
			$("#btn-save").on("click", ()=>{  //function(){}, ()=>{} this를 바인딩 하기 위해
				this.save();
		//$("#btn-save").on("click", function(){
			//_this.save();
			});
			$("#btn-update").on("click", ()=>{
				this.update();
			});
//			$("#btn-login").on("click", ()=>{  //전통방식 로그인
//				this.login();
//			});
		},

		save: function(){
//			alert('user의 save함수 호출됨');
			let data = {
					username: $("#username").val(),
					password: $("#password").val(),
					email: $("#email").val()
			};
			
//			console.log(data); //web브라우저에서 입력 확인 -> f12 console 창에 입력값 출력확인
			
			//ajax 호출시 default가 비동기 호출
			//ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
			//ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해주는듯
			$.ajax({
				//회원가입 수행 요청(100초 가정)
				type: "post",
				url: "/auth/joinProc",
				data: JSON.stringify(data), //http body데이터
				contentType: "application/json; charset=utf-8",	//body데이터가 어떤 타입인지(MINE)
//				dataType:"json"	//요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴게 Json이라면)=> javascript오브젝트로 변경
			}).done(function(resp) {
				if (resp.status==500) {
					alert("회원가입에 실패하였습니다.")					
				}else{
					alert("회원가입이 완료 되었습니다.");
//					alert(resp);
					console.log(resp);
					location.href="/";	
				}
			}).fail(function(error) {
				alert(JSON.stringify(error));
				
			});	// ajax 통신을 이용해 3개의 데이터를 json으로 변경하여 insert 요청
		},
		
		update: function(){
			let data = {
					id: $("#id").val(),
					username: $("#username").val(),
					password: $("#password").val(),
					email: $("#email").val()
			};
			$.ajax({
				type: "put",
				url: "/user/",
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
			}).done(function(resp) {
				alert("회원수정이 완료 되었습니다.");
				console.log(resp);
				location.href="/";
			}).fail(function(error) {
				alert(JSON.stringify(error));
				
			});
		}
}
index.init();

//		로그인 버튼설정
//		login: function(){ 
//			let data = {
//					username: $("#username").val(),
//					password: $("#password").val(),
//			};
//			$.ajax({
//				type: "post",
//				url: "/api/user/login",
//				data: JSON.stringify(data), //http body데이터
//				contentType: "application/json; charset=utf-8",	//body데이터가 어떤 타입인지(MINE)
//			}).done(function(resp) {
//				alert("로그인이 완료 되었습니다.");
//				console.log(resp);
//				location.href="/";
//			}).fail(function(error) {
//				alert(JSON.stringify(error));
//				
//			});	
//		
//		}

