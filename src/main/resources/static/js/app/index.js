

var main = {
  init : function() {
      var _this = this;
      $('#btn-save').on('click', function() {
          _this.save();
      });
      $('#btn-update').on('click', function() {
          _this.update();
      });
      $('#btn-delete').on('click', function() {
          _this.delete();
      });
  },
  save : function() {
      var data = {
        title: $('#title').val(),
        author: $('#author').val(),
        content: $('#content').val()
      };

      $.ajax({
          type: 'POST',
          url: '/api/v1/posts',
          dataType: 'text',
          //dataType: 'text',
          contentType: 'application/json',
          data: JSON.stringify(data)
      }).done ( function (data) {
          //msg = '요청성공 : ' + data;
          //alert(JSON.stringify(msg));
          window.location.href ='/';
      })
      .fail(function (error) {
          alert(JSON.stringify(error));
      }).always();
  },
  update : function() {
      var data = {
        title: $('#title').val(),
        content:  $('#content').val()
      };
      var id = $('#id').val();

      $.ajax({
          type: 'PUT',
          url: '/api/v1/posts/' + id,
          dataType: 'text',
          contentType: 'application/json; charset=utf-8',
          data : JSON.stringify(data)
      }).done(function() {
          alert('글이 수정 되었습니다.');
          window.location.href= '/';
      }).fail(function (error) {
          alert(JSON.stringify(error));
      });
  },
  delete : function() {
      var id = $('#id').val();

      $.ajax({
          type: 'DELETE',
          url: '/api/v1/posts' + id,
          dataType: 'jason',
          contentType: 'application/json; charset=utf-8'
      }).done(function() {
          alert('글이 삭제되었습니다.');
          window.location.href = '/';
      }).fail(function (error) {
          alert(JSON.stringify(error));
      }) ;
  }
};

main.init();