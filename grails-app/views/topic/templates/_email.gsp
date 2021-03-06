<div class="modal fade" id="sendInvitation" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header" style="background-color:#D3D3D3">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Send Invitation</h4>
            </div>

            <div class="modal-body">
                <g:form controller="topic" action="invite" class="form-horizontal">

                    <div class="form-group">

                        <label for="inputEmail" class="control-label col-xs-2">Email*</label>

                        <div class="col-xs-10">

                            <input type="email" name="email" class="form-control" id="inputEmail" placeholder="Email">

                        </div>

                    </div>

                    <div class="form-group">

                        <label for="topicSelect" class="control-label col-xs-2">Topic*</label>

                        <div class="col-xs-10">

                            <g:select class="form-control" id="topicSelect" name="id" optionKey="id" from="${subscribedTopics}"></g:select>

                        </div>

                    </div>


                    <div class="form-group">

                        <div class="col-xs-offset-2 col-xs-10">

                            <g:submitButton name="submit" type="submit" class="btn btn-primary">Invite</g:submitButton>
                            <button  class="btn btn-default" data-dismiss="modal">Cancel</button>

                        </div>

                    </div>

                </g:form>
            </div>

        </div>
    </div>
</div>