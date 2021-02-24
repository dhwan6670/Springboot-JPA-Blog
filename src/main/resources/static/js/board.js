let index = {
		//let_this=this; //function으로 사용시
		init:function(){
			$("#btn-save").on("click", ()=>{  //function(){}, ()=>{} this를 바인딩 하기 위해
				this.save();
		//$("#btn-save").on("click", function(){
			//_this.save();
			});
//			$("#btn-login").on("click", ()=>{  //전통방식 로그인
//				this.login();
//			});
		},

		save: function(){
			let data = {
					title: $("#title").val(),
					content: $("#content").val(),
			};
			$.ajax({
				type: "post",
				url: "/api/board",
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
			}).done(function(resp) {
				alert("글쓰기가 완료 되었습니다.");
				console.log(resp);
				location.href="/";
			}).fail(function(error) {
				alert(JSON.stringify(error));
				
			});
		}
}
index.init();

